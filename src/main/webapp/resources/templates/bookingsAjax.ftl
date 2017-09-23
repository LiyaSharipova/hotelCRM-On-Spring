<#if bookings?has_content>
<div class="form-group">
    <h4>Bookings</h4>
    <#list bookings as b>
    <#--<ul>-->
    <#--<li><a href="/admin/booking/${b.id}">${b.room.number} ${b.checkIn}-${b.checkOut}</a> </li>-->
    <#--</ul>-->
        <div class="radio">
            <label><input type="radio" name="booking"
                          value="${b.id}"><b>Room Number: </b>${b.room.number} <b>Dates: </b>${b.checkIn?date}-${b.checkOut?date}</label>
        </div>
    </#list>
</div>
<#--<input type="button" id="bookBtn" class="btn btn-success col-lg-offset-1"  onclick="getBookings()" value="Find Bookings"/>-->
<button type="submit" class="btn btn-success col-lg-offset-1">Create order</button>
<#else >
<p>No bookings are found</p>
</#if>
