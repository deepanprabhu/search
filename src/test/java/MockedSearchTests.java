import com.data.loader.JsonLoader;
import com.data.objects.Organization;
import com.data.objects.User;
import com.search.application.Query;
import org.apache.commons.jxpath.JXPathNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.FileNotFoundException;

@RunWith(PowerMockRunner.class)
@PrepareForTest(JsonLoader.class)
public class MockedSearchTests {

    /**
     * Query to pick one organization
     * @throws FileNotFoundException
     */
    @Test
    public void testGetOrganization() throws FileNotFoundException {
        Organization[] organizations = (Organization[]) Query.query("doc/organizations");

        Assert.assertEquals(organizations.length, 1);
        Assert.assertEquals(organizations[0].getName(), "Enthaze");
    }

    /**
     * Query to pick one user
     * @throws FileNotFoundException
     */
    @Test
    public void testGetAUser() throws FileNotFoundException {
        User user = (User) Query.query("doc/users[1]");

        Assert.assertEquals(user.getEmail(), "austinaguilar@flotonic.com");
    }


    /**
     * Test when query is invalid
     * @throws FileNotFoundException
     */
    @Test(expected = JXPathNotFoundException.class)
    public void testInvalidQuery() throws FileNotFoundException {
        Query.query("docs");
    }


    /**
     * Get user who submitted the first ticket
     */
    @Test
    public void testRelatedEntriesSubmittedUser() {
        User user = (User) Query.query("doc/tickets[1]/submitter");
        Assert.assertEquals(user.getName(), "Daniel Agüilar");
    }

    /**
     * Get user who was assigned the first ticket
     */
    @Test
    public void testRelatedEntriesAssignedUser() {
        User user = (User) Query.query("doc/tickets[1]/assignee");
        Assert.assertEquals(user.getName(), "Tyler Bates");
    }

    /**
     * Get user has no or empty Role
     */
    @Test
    public void testUserWithEmptyRole() {
        User user = (User) Query.query("doc/users[@role='']");
        Assert.assertEquals(user.getEmail(), "noroleuser@flotonic.com");
    }

}
