/**
 * BlogService
 */
app.factory('BlogService',function($http){
	var blogService={}
blogService.addBlog=function(blog)
{
		return $http.post("http://localhost:8080/proj2middleware/addblogpost",blog)
		}

return blogService;

})