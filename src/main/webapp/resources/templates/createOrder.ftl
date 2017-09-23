<#include "main.ftl"/>
<@main title="Create order"/>
<#macro m_body>
<div class="container">

    <div class="page-header text-center"><h1>Create order from booking</h1></div>
    <#if message ??>
        <div class="alert alert-success">
        ${message}
        </div>
    </#if>
    <form action="" method="post" id="search-form" class="form-horizontal">
        <div class="form-group">
            <div class="col-lg-5">
                <label for="login" lass="control-label"><i>Find bookings by login</i></label>
                <input type="text" placeholder="Login" id="login" name="login" class="form-control"
                       oninput="getBookings()">
            </div>
        </div>
        </br>
        <div id="bookings"></div>

    </form>

</div>
</#macro>

