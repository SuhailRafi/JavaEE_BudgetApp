<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:100,300,400,600" rel="stylesheet" type="text/css">
        <link href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css">
        <link type="text/css" rel="stylesheet" href="style.css">
        <title>Budgety</title>
    </head>
    <body>
   
    <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");  
%>

<%
if( session.getAttribute("userEmail") == null){
response.sendRedirect("signIn.html");
}
%>
       
        <div class="top">
        <h1 style="color:blue;"><a href="logout">Log out </a></h1>
       
            <div class="budget">
                <div class="budget__title">
                    Available Budget in <span class="budget__title--month">%Month%</span>:
                </div>
               
                <div class="budget__value">+ 2,345.64</div>
               
                <div class="budget__income clearfix">
                    <div class="budget__income--text">Income</div>
                    <div class="right">
                        <div class="budget__income--value">+ 4,300.00</div>
                        <div class="budget__income--percentage">&nbsp;</div>
                    </div>
                </div>
               
                <div class="budget__expenses clearfix">
                    <div class="budget__expenses--text">Expenses</div>
                    <div class="right clearfix">
                        <div class="budget__expenses--value">- 1,954.36</div>
                    </div>
                </div>
            </div>
        </div>
       
       
       
        <div class="bottom">
            <div class="add">
                <div class="add__container">
                <form action="incExp" method="post" >
                    <select class="add__type" name ="type">
                        <option value="inc" selected>+</option>
                        <option value="exp">-</option>
                    </select>
                    <input type="text" name="desc" class="add__description" placeholder="Add description">
                    <input type="number" name="value" class="add__value" placeholder="Value">
                    <button type="submit" class="add__btn"><i class="ion-ios-checkmark-outline"></i></button>
                 </form>  
                </div>
            </div>
           
            <div class="container clearfix">
                <div class="income">
                    <h2 class="icome__title">Income</h2>
                   
                    <div class="income__list">
                       
                       
                        <div class="item clearfix" id="income-0">
                            <div class="item__description">Salary</div>
                            <div class="right clearfix">
                                <div class="item__value">+ 2,100.00</div>
                                <div class="item__delete">
                                    <button class="item__delete--btn"><i class="ion-ios-close-outline"></i></button>
                                </div>
                            </div>
                        </div>
                        <c:forEach var = "income" items="${incomeList}">
                       
                       <div class="item clearfix" id="income-${income.id}">
                           <div class="item__description">${income.desc }</div>
                           <div class="right clearfix">
                               <div class="item__value">+ ${income.amount} </div>
                               <div class="item__delete">
                                   <button class="item__delete--btn"><i class="ion-ios-close-outline"></i></button>
                               </div>
                           </div>
                        </div>
 
    </c:forEach>
                        <!--
                        <div class="item clearfix" id="income-1">
                            <div class="item__description">Sold car</div>
                            <div class="right clearfix">
                                <div class="item__value">+ 1,500.00</div>
                                <div class="item__delete">
                                    <button class="item__delete--btn"><i class="ion-ios-close-outline"></i></button>
                                </div>
                            </div>
                        </div>
                        -->
                       
                    </div>
                </div>
               
               
               
                <div class="expenses">
                    <h2 class="expenses__title">Expenses</h2>
                   
                    <div class="expenses__list">
                       
                       
                        <div class="item clearfix" id="expense-0">
                            <div class="item__description">Apartment rent</div>
                            <div class="right clearfix">
                                <div class="item__value">- 900.00</div>
                                <div class="item__delete">
                                    <button class="item__delete--btn"><i class="ion-ios-close-outline"></i></button>
                                </div>
                            </div>
                        </div>
                       
                        <c:forEach var = "expense" items="${expenseList}">
                       
                        <div class="item clearfix" id="expense-${expense.id}">
                            <div class="item__description">${expense.desc}</div>
                            <div class="right clearfix">
                                <div class="item__value">- ${expense.amount}</div>
                                <div class="item__delete">
                                    <button class="item__delete--btn"><i class="ion-ios-close-outline"></i></button>
                                </div>
                            </div>
                        </div>
                       
                        </c:forEach>
                       
                       
                       
<!--
                        <div class="item clearfix" id="expense-1">
                            <div class="item__description">Grocery shopping</div>
                            <div class="right clearfix">
                                <div class="item__value">- 435.28</div>
                                <div class="item__percentage">10%</div>
                                <div class="item__delete">
                                    <button class="item__delete--btn"><i class="ion-ios-close-outline"></i></button>
                                </div>
                            </div>
                        </div>
                        -->
                       
                    </div>
                </div>
            </div>
           
           
        </div>
       
       
    </body>
</html>