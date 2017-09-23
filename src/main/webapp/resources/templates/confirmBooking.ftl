<#include "main.ftl"/>
<@main title="Confirm Booking"/>
<#macro m_body>
    <div class="page-header text-center">
        <h1>Confirm your booking</h1>
    </div>
    <div class="container">
        <ul>
            <li><h4>Room title: ${(room.roomType).title}</h4></li>
            <li><h4>Room number: ${room.number}</h4></li>
            <li><h4><span class="glyphicon glyphicon-user"></span>Adults ${(room.roomType).adults}
                <span class="glyphicon glyphicon-user"></span>Kids ${(room.roomType).kids}</h4></li>
            <li><h4>Check in: ${check_in}</h4></li>
            <li><h4>Check out: ${check_out}</h4></li>
            <li><h4>Total price: $${(room.roomType).price*days}</h4></li>
        </ul>
        <form action="" method="post">
            <button type="submit" id="confirmBtn" class="btn btn-success col-lg-offset-1">Confirm</button>
        </form>
    </div>
</#macro>