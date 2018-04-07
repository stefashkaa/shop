<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
  <c:import url="fragments/head.jsp" />
  <body>
    <c:import url="fragments/header.jsp" />
    <div id="all">
      <div id="content">
        <div class="container">
          <div class="row">

            <div class="col-sm-8 col-sm-offset-2">
              <ul class="breadcrumb">
                <li><a href="index.html">Home</a></li>
                <li>Checkout</li>
              </ul>
            </div>

            <div class="col-sm-8 col-sm-offset-2">
              <c:if test="${not empty error}">
                  <div id="error" class="alert alert-danger alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <i class="icon fa fa-exclamation-circle"></i> ${error}
                  </div>
                  <c:remove var="error" scope="session" />
              </c:if>
            </div>

            <div class="col-sm-8 col-sm-offset-2" id="checkout">

              <div class="box">
                <form action="checkout.html" method="POST">
                  <h3>Checkout</h3>

                  <div class="content">
                    <div class="row">
                      <div class="col-sm-6">
                        <div class="form-group">
                          <label>Name</label> <span class="required">(*)</span>
                          <input type="text" class="form-control" name="name" />
                        </div>
                      </div>
                      <div class="col-sm-6">
                        <div class="form-group">
                          <label>Phone</label> <span class="required">(*)</span>
                          <input type="text" class="form-control" name="phone" />
                        </div>
                      </div>
                    </div>

                    <div class="row">
                      <div class="col-sm-12">
                        <div class="form-group">
                          <label>Address</label> <span class="required">(*)</span>
                          <textarea class="form-control" name="address" rows="5"></textarea>
                        </div>
                      </div>
                    </div>

                    <div class="row">
                      <div class="col-sm-12">
                        <div class="form-group">
                          <label>Note</label>
                          <textarea class="form-control" name="note" rows="3"></textarea>
                        </div>
                      </div>
                    </div>

                  </div>

                  <div class="box-footer">
                    <div class="pull-left">
                      <a href="cart.html" class="btn btn-default">
                        <i class="fa fa-chevron-left"></i>Back to shopping cart
                      </a>
                    </div>
                    <div class="pull-right">
                      <button type="submit" class="btn btn-primary" name="submit">
                        Place order<i class="fa fa-chevron-right"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>

            </div>
          </div>
        </div>
      </div>
      <c:import url="fragments/footer.jsp" />
    </div>
    <c:import url="fragments/scripts.jsp" />
  </body>
</html>