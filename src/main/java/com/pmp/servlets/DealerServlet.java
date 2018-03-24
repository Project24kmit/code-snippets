package com.pmp.servlets;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.pmp.elements.ContactDetails;
import com.pmp.elements.Dealer;
import com.pmp.elements.Product;
import com.pmp.services.CategoryService;
import com.pmp.services.DealerService;
import com.pmp.services.ProductService;
import com.pmp.sql.DatabaseConnector;

@WebServlet(urlPatterns = "/dealer.do", initParams = { @WebInitParam(name = "basePath", value = "/") })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50)
public class DealerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection dbconnection = DatabaseConnector.getDBConnection();
	DealerService dealerService = new DealerService(dbconnection);
	CategoryService categoryService = new CategoryService(dbconnection);
	ProductService productService = new ProductService(dbconnection);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession(false).getAttribute("userId") != null) {
			int dealerId = (int) request.getSession(false).getAttribute("userId");
			request.setAttribute("categories", categoryService.getAllCategoriesByDealerId(dealerId));
			request.setAttribute("products", productService.getAllProductsByDealerId(dealerId));
			request.getRequestDispatcher("jsp/dealer-home-page.jsp").forward(request, response);
		} else
			request.getRequestDispatcher("jsp/home-page.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("addProductSubmit") != null) {
			dealerService.addNewProduct(mapProductDetails(request));
			int dealerId = (int) request.getSession(false).getAttribute("userId");
			request.setAttribute("categories", categoryService.getAllCategoriesByDealerId(dealerId));
			request.setAttribute("products", productService.getAllProductsByDealerId(dealerId));
			request.getRequestDispatcher("jsp/dealer-home-page.jsp").forward(request, response);
		}

		else if (request.getParameter("updateProductSubmit") != null) {
			int dealerId = (int) request.getSession(false).getAttribute("userId");
			productService.updateProduct(Integer.parseInt(request.getParameter("productId")),
					mapProductDetails(request));
			request.setAttribute("categories", categoryService.getAllCategoriesByDealerId(dealerId));
			request.setAttribute("products", productService.getAllProductsByDealerId(dealerId));
			request.getRequestDispatcher("jsp/dealer-home-page.jsp").forward(request, response);
		}

		else if (request.getParameter("deleteProductSubmit") != null) {
			int dealerId = (int) request.getSession(false).getAttribute("userId");
			productService.deleteProduct(Integer.parseInt(request.getParameter("productId")));
			request.setAttribute("categories", categoryService.getAllCategoriesByDealerId(dealerId));
			request.setAttribute("products", productService.getAllProductsByDealerId(dealerId));
			request.getRequestDispatcher("jsp/dealer-home-page.jsp").forward(request, response);
		}

		else if (request.getParameter("viewProfileSubmit") != null) {
			int dealerId = (int) request.getSession(false).getAttribute("userId");
			request.setAttribute("dealerDetails", dealerService.getDealerByDealerId(dealerId));
			request.getRequestDispatcher("jsp/dealer-profile-page.jsp").forward(request, response);
		}

		else if (request.getParameter("updateDealerDetails") != null) {
			int dealerId = (int) request.getSession(false).getAttribute("userId");
			dealerService.updateDealerDetails(dealerId, mapDealerDetails(request));
			request.setAttribute("dealerDetails", dealerService.getDealerByDealerId(dealerId));
			request.getRequestDispatcher("jsp/dealer-profile-page.jsp").forward(request, response);
		}

		else if (request.getParameter("viewReports") != null) {
			int dealerId = (int) request.getSession(false).getAttribute("userId");
			request.setAttribute("categories", categoryService.getAllCategoriesByDealerId(dealerId));
			request.setAttribute("products", productService.getAllProductsByDealerId(dealerId));
			request.getRequestDispatcher("jsp/dealer-reports-page.jsp").forward(request, response);
		}

		else if (request.getParameter("addCategorySubmit") != null) {
			dealerService.addNewCategory(request.getParameter("categoryName"),
					(int) request.getSession(false).getAttribute("userId"));
			int dealerId = (int) request.getSession(false).getAttribute("userId");
			request.setAttribute("categories", categoryService.getAllCategoriesByDealerId(dealerId));
			request.setAttribute("products", productService.getAllProductsByDealerId(dealerId));
			request.getRequestDispatcher("jsp/dealer-home-page.jsp").forward(request, response);
		}

		else if (request.getParameter("registerDealerPage") != null) {
			request.getRequestDispatcher("jsp/dealer-registration-page.jsp").forward(request, response);
		}

		else if (request.getParameter("registerDealer") != null) {
			int result = dealerService.insertDealerDetails(mapDealerDetails(request));
			String message = "";

			if (result != -1)
				message = result + "";
			else
				message = "Error";
			request.setAttribute("message", message);
			request.getRequestDispatcher("jsp/dealer-registration-page.jsp").forward(request, response);
		}

		else {
			int userId = Integer.parseInt(request.getParameter("userId"));
			String password = request.getParameter("password");

			boolean isDealerValid = dealerService.isDealerValid(userId, password);

			if (isDealerValid) {
				request.getSession().setAttribute("userId", userId);
				request.getSession().setAttribute("csrfToken", generateCSRFToken());
				String sessionid = request.getSession().getId();
				response.setHeader("Set-Cookie", "JSESSIONID=" + sessionid + ";");
				request.setAttribute("categories", categoryService.getAllCategoriesByDealerId(userId));
				request.setAttribute("products", productService.getAllProductsByDealerId(userId));
				request.getRequestDispatcher("jsp/dealer-home-page.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "Invalid credientials");
				request.getRequestDispatcher("jsp/home-page.jsp").forward(request, response);
			}
		}
	}

	private Product mapProductDetails(HttpServletRequest request) {
		Product product = new Product();
		product.setProductName(request.getParameter("productName"));
		product.setProductDescription(request.getParameter("productDescription"));
		// product.setDealerId((int) request.getSession(false).getAttribute("userId"));
		product.setDealerId(10);
		product.setCategoryId(categoryService.getCategoryIdByCategoryName(request.getParameter("productCategory")));
		product.setCost(Float.parseFloat(request.getParameter("productCost")));
		product.setStockQuantity(Integer.parseInt(request.getParameter("productQuantity")));
		product.setImageFilePath(uploadImageFile(request));

		return product;
	}

	private String uploadImageFile(HttpServletRequest request) {
		String imageFilePath = null;
		try {
			final String SAVE_DIR = "uploadFiles";
			String fileName = request.getSession().getAttribute("userId").toString();
			String appPath = request.getServletContext().getRealPath("");
			String savePath = appPath + File.separator + SAVE_DIR;

			// creates the save directory if it does not exists
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}

			Part part = request.getPart("productImage");
			fileName = fileName + "_" + extractFileName(part);
			// refines the fileName in case it is an absolute path
			fileName = new File(fileName).getName();
			part.write(savePath + File.separator + fileName);
			imageFilePath = "../" + SAVE_DIR + "/" + fileName;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageFilePath;
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf('"') + 1, s.length() - 1);
			}
		}
		return "";
	}

	private Dealer mapDealerDetails(HttpServletRequest request) {
		Dealer dealer = new Dealer();
		dealer.setName(request.getParameter("firstName") + " " + request.getParameter("lastName"));
		dealer.setCompany(request.getParameter("company"));
		ContactDetails contactDetails = new ContactDetails();
		contactDetails.setContactNumber(request.getParameter("mobile"));
		contactDetails.setAddress(request.getParameter("address"));
		contactDetails.setMailId(request.getParameter("email"));
		dealer.setContactDetails(contactDetails);
		return dealer;
	}

	public static String generateCSRFToken() {
		String token = UUID.randomUUID().toString();
		return token;
	}

}
