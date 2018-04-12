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
            
            <div class="col-sm-10 col-sm-offset-1">
              <ul class="breadcrumb">
                <li><a href="index.html">Home</a>
                </li>
                <li>Shopping cart</li>
              </ul>
            </div>

            <div class="col-sm-10 col-sm-offset-1">
              <c:if test="${not empty error}">
                  <div class="col-sm-10 col-sm-offset-1 alert alert-danger alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <i class="icon fa fa-exclamation-circle"></i> ${error}
                  </div>
                  <c:remove var="error" scope="session" />
              </c:if>
            </div>

            <div class="col-sm-10 col-sm-offset-1" id="basket">

              <div class="box">
                <form action="cart.html" method="POST">
                  <h3>Shopping cart</h3>
                  <p class="text-muted">You currently have ${cart.count} items in your cart.</p>
                  <div class="table-responsive">
                    <table class="table">
                      <thead>
                        <tr>
                          <th colspan="2">Product</th>
                          <th>Quantity</th>
                          <th>Price</th>
                          <th colspan="2">Sub Total</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach var="item" items="${cart.items}">
                            <tr>
                              <td>
                                <a href="product.html?id=item.product.id">
                                  <img src="static/upload/${item.product.image}" alt="Product" />
                                </a>
                              </td>
                              <td>
                                <a href="product.html?id=${item.product.id}">${item.product.name}</a>
                              </td>
                              <td>
                                <input type="number" name="${item.product.id}" value="${item.quantity}" 
                                       class="form-control" min="1" max="10"
                                       onchange="changeTotal(${item.product.id}, ${cart.productIds})"/>
                              </td>
                              <td name="${item.product.id}.price" class="good-price">${item.product.price}$</td>
                              <td name="${item.product.id}.subTotal" class="good-price">${item.subTotal}$</td>
                              <td>
                                <a href="cart.html?action=remove&id=${item.product.id}"><i class="fa fa-trash-o"></i></a>
                              </td>
                            </tr>
                        </c:forEach>
                      </tbody>
                      <tfoot>
                        <tr>
                          <th colspan="4">Total</th>
                          <th name="total" class="good-price" colspan="2">${cart.total}$</th>
                        </tr>
                      </tfoot>
                    </table>
                  </div>

                  <div class="box-footer">
                    <div class="pull-left">
                      <button type="submit" name="action" value="index" class="btn btn-default"><i class="fa fa-chevron-left"></i> Continue shopping</button>
                    </div>
                    <div class="pull-right">
                      <button type="submit" name="action" class="btn btn-default"><i class="fa fa-refresh"></i> Update shopping cart</button>
                      <button type="submit" name="action" value="checkout" class="btn btn-primary">Proceed to checkout <i class="fa fa-chevron-right"></i></button>
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