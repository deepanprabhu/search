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

    @Test
    public void testGetOrganization() throws FileNotFoundException {
        Organization[] organizations = (Organization[]) Query.query("doc/organizations");

        Assert.assertEquals(organizations.length, 1);
        Assert.assertEquals(organizations[0].getName(), "Enthaze");
    }

    @Test(expected = JXPathNotFoundException.class)
    public void testWrongQuery() throws FileNotFoundException {
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

}
