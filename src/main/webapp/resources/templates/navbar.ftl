<!-- Navigation -->
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button roomClass="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">The Fullerton Hotel</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="#">About</a>
                </li>
            <@security.authorize access="!hasRole('ROLE_HOTEL_ADMIN')">
                <li><a href="/rooms/standart">Rooms</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Contact</a></li>
            </@security.authorize>

            <@security.authorize access="hasRole('ROLE_HOTEL_ADMIN')">
                <li><a href="/admin/createOrder">Create order</a></li>
            </@security.authorize>

            <@security.authorize access="isAnonymous()">
                <li><a href="/registration">Sign up</a></li>
                <li><a href="/login" id="login">Log in</a></li>
            </@security.authorize>
            <@security.authorize access="!isAnonymous()">
                <li><a href="/logout">Log out</a></li>
            </@security.authorize>

            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>