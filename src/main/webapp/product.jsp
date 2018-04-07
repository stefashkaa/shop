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

            <div class="col-sm-12"></div>

            <div class="col-sm-3">
              <div class="panel panel-default sidebar-menu">

                <div class="panel-heading">
                  <h3 class="panel-title">Categories</h3>
                </div>

                <div class="panel-body">
                  <ul class="nav nav-pills nav-stacked category-menu">
                    <c:forEach var="category" items="${categories}">
                        <li>
                          <a href="category.html?id=${category.id}">${category.name}</a>
                        </li>
                    </c:forEach>
                  </ul>
                </div>
              </div>
            </div>

            <div class="col-sm-9">
              <ul class="breadcrumb">
                <li><a href="index.html">Home</a></li>
                <li>Product</li>
                <li>${product.name}</li>
              </ul>

              <div class="row box" id="productMain">
                <div class="col-sm-12">
                  <h4 class="mainHeading">Product Details</h4>
                </div>

                <div class="col-sm-3">
                  <div id="mainImage">
                    <img src="<c:url value="static/upload/${product.image}" />"
                         alt="Product" class="img-responsive" />
                  </div>
                  <p class="buttons">
                    <a href="cart.html?action=add&id=${product.id}" class="btn btn-primary">
                      <i class="fa fa-shopping-cart"></i>Add to cart
                    </a>
                  </p>
                </div>

                <div class="col-sm-9">
                  <table class="table table-bordered">
                    <tr>
                      <td>Name</td>
                      <td>${product.name}</td>
                    </tr>
                    <tr>
                      <td>Price</td>
                      <td>${product.price}$</td>
                    </tr>
                    <tr>
                      <td>Description</td>
                      <td>${product.description}</td>
                    </tr>
                  </table>
                </div>
              </div>

              <div class="box" id="details">
                <div class="social">
                  <h4>Show it to your friends</h4>
                  <p>
                    <a href="https://www.facebook.com/sharer/sharer.php?u=${pageContext.request.contextPath}/product.html?id=${product.id}&t=${product.name}"
                       class="external facebook"
                       data-animate-hover="pulse"
                       onclick="javascript:window.open(this.href, '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=300,width=600');return false;"
                       target="_blank" title="Share on Facebook">
                      <i class="fa fa-facebook"></i>
                    </a>
                    <a href="https://twitter.com/share?url=${pageContext.request.contextPath}/product.html?id=${product.id}&via=${product.name}&text=${product.description}"
                       class="external twitter"
                       data-animate-hover="pulse"
                       onclick="javascript:window.open(this.href, '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=300,width=600');return false;"
                       target="_blank" title="Share on Twitter">
                      <i class="fa fa-twitter"></i>
                    </a>
                    <a href="https://plus.google.com/share?url=${pageContext.request.contextPath}/product.html?id=${product.id}"
                       class="external gplus"
                       data-animate-hover="pulse"
                       onclick="javascript:window.open(this.href, '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=350,width=480');return false;"
                       target="_blank" title="Share on Google+">
                      <i class="fa fa-google-plus"></i>
                    </a>
                  </p>
                </div>
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