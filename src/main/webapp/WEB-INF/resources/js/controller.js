
/* 
 * An AngularJS module defines an application.

The module is a container for the different parts of an application.

The module is a container for the application controllers.

Controllers always belong to a module.
 */
var cartApp = angular.module ("cartApp", []);

//AngularJS application mainly relies on controllers to control the flow of data in the application.
//Scope is a special javascript object which plays the role of joining controller with the views. Scope contains the model data.
//In controllers, model data is accessed via $scope object.
//The AngularJS $http service makes a request to the server, and returns a response.
cartApp.controller("cartCtrl", function ($scope, $http){

    $scope.refreshCart = function () {
        $http.get('/eGrocery/rest/cart/'+$scope.cartId).success(function (data) {
           $scope.cart = data;         
          
        });
    };
    
    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        
        $scope.refreshCart();
    };

    $scope.clearCart = function () {
        $http.delete('/eGrocery/rest/cart/'+ $scope.cartId).success($scope.refreshCart());
        	 
        	
   };
 

  

    $scope.addToCart = function (productId) {
        $http.put('/eGrocery/rest/cart/add/'+ productId).success(function () {
         // $scope.refreshCart($http.get('/eGrocery/rest/cart/cartId'));
            alert("Product successfully added to the cart!");
        });
    };
    
    $scope.updateCart = function (productId,quantity) {
        $http.put('/eGrocery/rest/cart/update/'+ productId+'/'+quantity).success(function () {
            $scope.refreshCart();
            alert("Product successfully updated!");
        });
    };
    
    $scope.removeFromCart = function (productId) {
        $http.put('/eGrocery/rest/cart/remove/'+productId+'/'+$scope.cartId).success(function (data) {
            $scope.refreshCart();
        });
    };
    
    $scope.calGrandTotal = function(){ 
    	
    	var grandTotal = 0;
    	
    	for(var i = 0; i < $scope.cart.cartItems.length; i++){ 
    		grandTotal += $scope.cart.cartItems[i].totalPrice; 
    	}
    	
    	return grandTotal;	
    };
        
});