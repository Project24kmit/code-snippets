	<!-- Sidebar -->
<div id="sidebar-wrapper">
    <form method="POST" id="sidebar" action="/admin">
        <input type="hidden" name="action" id="type"/>
        <ul class="sidebar-nav">
            <li>
                <button type="submit" class="btn btn-link" onclick="document.getElementById('type').value='inbox';">Inbox</button>
            </li>
            <li>
                <button type="submit" class="btn btn-link" onclick="document.getElementById('type').value='viewDealers';">View Dealers</button>
            </li>
            <li>
                <button  type="submit" class="btn btn-link" onclick="document.getElementById('type').value='unregister';">Unregister Dealer</button>
            </li>
            <li>
                <button type="submit" class="btn btn-link" onclick="document.getElementById('type').value='overall';">Overall Reports </button>
            </li>
            <li>
                <button type="submit" class="btn btn-link" onclick="document.getElementById('type').value='dealerWise';"> Dealer Wise Reports </button>
            </li>
        </ul>
    </form>
</div>