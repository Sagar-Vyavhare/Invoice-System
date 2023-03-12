<%@include file="Header.jsp" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
%>
<script>
    $(document).ready(function () {
        getDetails();
        $("#submit").click(function () {
            addpayment();
        })
    })
    function getDetails() {
        $.ajax({
            url: 'http://localhost:9090/api/invoice_detailsbyid?id=' +<%=id%>,
            method: 'get',
            contentType: 'application/json',
            success: function (resp) {
                $("#invoice_id").val(resp.invoice_id);
                $("#cust_name").val(resp.customer_name);
                $("#invoice_date").val(resp.invoice_date);
                $("#ttl_amt").val(resp.total_ammount);
                $("#remaining_amt").val(resp.remaining_ammount);
                $("#paid_amt").val(resp.paid_ammount);
            }
        })
    }
    function addpayment() {
        let p_date=$("#payment_date").val();
        let p_amt=$("#payment_amt").val();
        let mode=$("#mode").val();
        let desc=$("#description").val();
        let obj={"payment_date":p_date,"payment_ammount":p_amt,"payment_mode":mode,"description_print":desc,invoice_details:{"invoice_id":<%=id%>}};
        $.ajax({
            url:'http://localhost:9090/api/payments',
            method:'post',
            data:JSON.stringify(obj),
            contentType: 'application/json',
            success: function (resp) {
                        alert(resp);
                        window.location.href="Invoice.jsp";
                    }
        })
    }
</script>
<a href="Invoice.jsp">All Invoices</a>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h2>Make payment</h2>
    </div>
    <div class="panel-body">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="">Invoice Id</label>
                    <input type="text" name="" id="invoice_id" class="form-control" disabled>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="">Customer Name</label>
                    <input type="text" name="" id="cust_name" class="form-control"disabled>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="">Invoice Date</label>
                    <input type="text" name="" id="invoice_date" class="form-control"disabled>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="">Total Amount</label>
                    <input type="text" name="" id="ttl_amt" class="form-control"disabled>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="">Remaining amount</label>
                    <input type="text" name="" id="remaining_amt" class="form-control" disabled>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="">Paid Ammount</label>
                    <input type="text" name="" id="paid_amt" class="form-control"disabled>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="">Payment Date</label>
                    <input type="date" name="" id="payment_date" class="form-control" required>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="">Payment Amount</label>
                    <input type="text" name="" id="payment_amt" class="form-control" required>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="">Payment Mode</label>
                    <select name="" id="mode" class="form-control">
                        <option value="" selected disabled required>Select payment mode</option>
                        <option value="Cash">Cash</option>
                        <option value="UPI">UPI</option>
                        <option value="Check">Check</option>
                        <option value="Net Banking">Net Banking</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="">Description</label>
                    <input type="text" name="" id="description" class="form-control">
                </div>
            </div>
        </div>
    </div>
    <div class="panel-footer">
        <input type="button" id="submit" value="Submit"class="btn btn-primary">
    </div>
</div>
<%@include file="Footer.jsp" %>