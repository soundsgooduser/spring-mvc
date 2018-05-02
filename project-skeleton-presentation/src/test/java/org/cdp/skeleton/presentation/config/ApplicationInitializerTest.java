package org.cdp.skeleton.presentation.config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppRootConfiguration.class, AppWebMvcConfigurerAdapter.class})
public class ApplicationInitializerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    // integration test - full flow
    @Test
    public void testLoadNotification() throws Exception {
        final String expectedContent = "{\"notificationSubjAndBody\":\"notificationSubjectTest, notificationBodyTest\"}";
        final ResultActions resultActions = mockMvc.perform(get("/notifications/load-notification"));
        resultActions.andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
        final MvcResult mvcResult = resultActions.andReturn();
        final String contentAsString = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(expectedContent, contentAsString);
    }
}
