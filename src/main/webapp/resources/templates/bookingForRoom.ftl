<@sf.form action="" method="post" modelAttribute="bookingForm"  role="form">
<div class="form-group">
    <label for="check_in">Check in</label>
    <div class='input-group date' id="check_in">
        <@sf.input path="checkIn" cssClass="form-control" />
        <span class="input-group-addon">
            <span class="glyphicon glyphicon-calendar"></span>
                            </span>
    </div>
</div>
<div class="form-group">
    <label for="check_out">Check out</label>
    <div class='input-group date' id="check_out">
        <@sf.input path="checkOut" cssClass="form-control" />
        <span class="input-group-addon">
            <span class="glyphicon glyphicon-calendar"></span>
                            </span>
    </div>
</div>
<button type="submit" id="roomSearchBtn" class="btn btn-success">Book</button>
    <p><@sf.errors path="checkIn" cssClass="error"/></p>

</@sf.form>

<#if checkIn??>


</#if>
