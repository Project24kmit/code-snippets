	<!-- Sidebar -->
<div id="sidebar-wrapper">
    <form method="POST" id="sidebar" action="/admin">
        <input type="hidden" name="action" id="type"/>
        <ul class="sidebar-nav">
            <li>
                <button type="submit" class="btn btn-link" onclick="document.getElementById('type').value='inbox';">inbox</button>
            </li>
            <li>
                <button type="submit" class="btn btn-link" onclick="document.getElementById('type').value='viewDealers';">View dealers</button>
            </li>
            <li>
                <button  type="submit" class="btn btn-link" onclick="document.getElementById('type').value='unregister';">Unregister dealer</button>
            </li>
            <li>
                <button type="submit" class="btn btn-link">reports </button>
            </li>
            <li>
                <button type="submit" class="btn btn-link">reports </button>
            </li>
            <li>
                <button type="submit" class="btn btn-link"></button> 
            </li>
        </ul>
    </form>
</div>