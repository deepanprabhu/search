import com.data.objects.Organization;
import com.data.objects.User;
import com.search.application.Query;
import org.apache.commons.jxpath.JXPathNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Iterator;

public class MockedSearchTests {

    /**
     * Query to pick one organization
     *
     * @throws FileNotFoundException
     */
    @Test
    public void testGetOrganization() throws FileNotFoundException {
        Iterator iterator = Query.query("doc/organizations");
        Organization organization = (Organization) iterator.next();
        Assert.assertEquals(organization.getName(), "Enthaze");
    }

    /**
     * Query to pick one user
     *
     * @throws FileNotFoundException
     */
    @Test
    public void testGetAUser() throws FileNotFoundException {
        Iterator iterator = Query.query("doc/users[1]");
        User user = (User) iterator.next();
        Assert.assertEquals(user.getEmail(), "austinaguilar@flotonic.com");
    }


    /**
     * Test when query is invalid
     *
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
        Iterator iterator = Query.query("doc/tickets[1]/submitter");
        User user = (User) iterator.next();
        Assert.assertEquals(user.getName(), "Daniel Agüilar");
    }

    /**
     * Get user who was assigned the first ticket
     */
    @Test
    public void testRelatedEntriesAssignedUser() {
        Iterator iterator = Query.query("doc/tickets[1]/assignee");
        User user = (User) iterator.next();
        Assert.assertEquals(user.getName(), "Tyler Bates");
    }

    /**
     * Get user has no or empty Role
     */
    @Test
    public void testUserWithEmptyRole() {
        Iterator iterator = Query.query("doc/users[@role='']");
        User user = (User) iterator.next();
        Assert.assertEquals(user.getEmail(), "noroleuser@flotonic.com");
    }

}
