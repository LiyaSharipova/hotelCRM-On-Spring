<div class="row">
    <div class="col-lg-12">
        <h3>Book a room</h3>
        <br/>
        <hr/>
        <div class="container">
        <@sf.form action="/" method="post" modelAttribute="roomSearchForm" class="form-horizontal" role="form">

            <div class="container">
                <div class='col-md-2'>
                    <div class="form-group">
                        <label for="check_in">Check in</label>
                        <div class='input-group date' id="check_in">
                            <@sf.input path="checkIn" cssClass="form-control"/>
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                </div>
                <div class='col-md-2 col-xs-offset-1'>
                    <div class="form-group">
                        <label for="check_out">Check out</label>
                        <div class='input-group date' id="check_out">
                        <#--<input roomClass='text' class="form-control"/>-->
                            <@sf.input path="checkOut" cssClass="form-control"/>
                            <#--<@sf.errors path="checkOut" cssClass="error"/>-->
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                </div>
                <div class='col-xs-1 col-xs-offset-1'>
                    <div class="form-group">
                        <label for="adults">Adults</label>
                        <@sf.select path="adults" cssClass="form-control" id="adults">
                            <option>1</option>
                            <option selected>2</option>
                            <option>3</option>
                            <option>4</option>
                        </@sf.select>
                    </div>
                </div>
                <div class='col-xs-1 col-xs-offset-1'>
                    <div class="form-group">
                        <label for="kids">Kids</label>
                        <@sf.select path="kids" cssClass="form-control" id="kids">
                            <option>0</option>
                            <option>1</option>
                            <option>2</option>
                        </@sf.select>
                    </div>
                </div>
                <div class="col-md-2 col-xs-offset-1 ">
                <#--<div class="form-group">-->
                    <button type="submit" id="roomSearchBtn" class="btn btn-success">Search</button>
                </div>
            <#--</div>-->
            </div>
            <@sf.errors path="checkIn" cssClass="error"/>
        </@sf.form>

        </div>
        <hr/>
    </div>
</div>