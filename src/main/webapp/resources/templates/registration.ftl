<#include "main.ftl"/>


<#macro m_body>
<div class="page-header text-center">
    <h2>Registration</h2>
</div>

<div class="container">

    <@sf.form action="/registration" method="post" modelAttribute="userform" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="name" class="control-label col-sm-2">Name</label>
            <div class="col-sm-5">
                <@sf.input path="name" id="name" cssClass="form-control" placeholder="Name"/><br/>
                <@sf.errors path="name" cssClass="error"/>
            </div>
        </div>

        <div class="form-group">
            <label for="login" class="control-label col-sm-2">Login</label>
            <div class="col-sm-5">
                <@sf.input path="login" id="login" cssClass="form-control" placeholder="Login"/>
            <@sf.errors path="login" cssClass="error"/>
            </div>
        </div>

        <div class="form-group">
            <label for="phoneNumber" class="control-label col-sm-2">Phone number</label>
            <div class="col-sm-5">
                <@sf.input path="phoneNumber" id="phoneNumber" cssClass="form-control"  placeholder="Phone number"/>
            <@sf.errors path="phoneNumber" cssClass="error"/>
            </div>
        </div>


        <div class="form-group">
            <label for="email" class="control-label col-sm-2">Email</label>
            <div class="col-sm-5">
                <@sf.input path="email" id="email" cssClass="form-control" placeholder="Email"/>
            <@sf.errors path="email" cssClass="error"/>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="control-label col-sm-2">Password</label>
            <div class="col-sm-5">
                <@sf.input path="password"  id="password" cssClass="form-control"  placeholder="Password"/>
            <@sf.errors path="password"cssClass="error"/>
            </div>
        </div>
        <div class="form-group">
            <label for="repassword" class="control-label col-sm-2">Confirm password</label>
            <div class="col-sm-5">
                <@sf.input path="repassword" id="repassword" cssClass="form-control" placeholder="Confirm password"/>
            <@sf.errors path="repassword" cssClass="error"/>
            </div>
        </div>
        <div class="col-sm-offset-2 col-sm-5">
            <button type="submit" class="btn btn-success">Sign up</button>
        </div>
    </@sf.form>
</div>
</#macro>

<@main title="Registration"/>