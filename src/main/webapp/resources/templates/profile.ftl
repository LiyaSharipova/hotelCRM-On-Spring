<#include "main.ftl"/>
<@main title="Profile"/>
<#macro m_body>
<div class="page-header text-center"><h1>Profile</h1></div>
<div class="container">
    <div class="row">
        <#if message ??>
            <div class="alert alert-success">
            ${message}
            </div>

        </#if>
        <ul>
            <li><h4>Name: ${guest.name}</h4></li>
            <li><h4>Login: ${guest.credentials.login}</h4></li>
            <li><h4>Email: ${guest.credentials.email}</h4></li>
            <li><h4>Phone Number: ${guest.phoneNumber}</h4></li>
        </ul>
        </br>
        <h3>Bookings</h3>
        <#if bookings?has_content>
            <#list bookings as b>
                <ul>
                    <div class="col-md-4">
                        <li><h4>Check in: ${b.checkIn?date}</h4></li>
                        <li><h4>Check out: ${b.checkOut?date}</h4></li>
                        <li><h4>Room Number: ${b.room.number}</h4></li>

                    <#--<a href="/cancelBooking/${b.id}"> Cancel</a>-->
                        <form action="/cancelBooking/${b.id}" method="post">
                            <button type="submit" name="your_name" value="your_value" class="btn-link">
                                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Cancel
                            </button>
                        </form>
                    </div>
                    <div class="col-md-8">
                        <div class="col-sm-6 col-lg-6 col-md-6">
                            <div class="thumbnail">
                                <img class="room_img_preview"
                                     src="/images/hotels/rooms/${(b.room.roomType.photos)[0].path} " alt="">
                                <div class="caption">
                                    <h4><a href="/rooms/${b.room.roomType.id}">${b.room.roomType.title}</a>
                                    </h4>
                                    <p> ${(b.room.roomType.description?split("."))[0]}</p>
                                </div>
                                <div class="ratings">
                                    <h4 class="pull-right"><b>$${b.room.roomType.price}</b></h4>
                                    <p>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>

                </ul>
            </#list>
        <#else><h4>No bookings found</h4>
        </#if>
    </div>
</div>
</#macro>