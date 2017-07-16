import static org.mockito.Mockito.when;

import java.net.URISyntaxException;

import org.arpit.java2blog.bean.User;
import org.arpit.java2blog.controller.NavigatorService;
import org.arpit.java2blog.controller.UserProfileController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class UserprofileControllerTester {
	
   //@InjectMocks annotation is used to create and inject the mock object
   @InjectMocks 
   UserProfileController mathApplication = new UserProfileController();

   //@Mock annotation is used to create the mock object to be injected
   @Mock
   NavigatorService calcService;

   @Test
   public void testAdd() throws URISyntaxException{
      //add the behavior of calc service to add two numbers
      User user=new User();
      user.setId(2);
	   when(calcService.getProfile()).thenReturn(user);
		
      //test the add functionality
      Assert.assertEquals(mathApplication.updateUser(null),user);
   }
}

