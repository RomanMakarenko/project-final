package com.javarush.jira.profile.internal.web;

import com.javarush.jira.AbstractControllerTest;
import com.javarush.jira.profile.ContactTo;
import com.javarush.jira.profile.internal.ProfileMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Set;

import static com.javarush.jira.common.util.JsonUtil.writeValue;
import static com.javarush.jira.login.internal.web.UserController.REST_URL;
import static com.javarush.jira.login.internal.web.UserTestData.*;
import static com.javarush.jira.profile.internal.web.ProfileTestData.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class ProfileRestControllerTest extends AbstractControllerTest {
    @Autowired
    ProfileMapper profileMapper;

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    public void testGetAuthProfile() throws Exception {
        USER_PROFILE_TO.setId(ADMIN_ID);
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(PROFILE_TO_MATCHER.contentJson(USER_PROFILE_TO));
    }

    @Test
    @WithUserDetails(value = GUEST_MAIL)
    public void testGetGuestProfile() throws Exception {
        GUEST_PROFILE_EMPTY_TO.setId(GUEST_ID);
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(PROFILE_TO_MATCHER.contentJson(GUEST_PROFILE_EMPTY_TO));
    }

    @Test
    @WithUserDetails(value = USER_MAIL)
    void testUpdateAuth() throws Exception {
        USER_PROFILE_TO.setMailNotifications(
            Set.of("assigned", "three_days_before_deadline", "two_days_before_deadline",
                "one_day_before_deadline", "deadline", "overdue"));
        USER_PROFILE_TO.setContacts(
            Set.of(new ContactTo("skype", "newSkype"),
                new ContactTo("mobile", "+380987654321"),
                new ContactTo("website", "new.com"),
                new ContactTo("github", "newGitHub"),
                new ContactTo("tg", "newTg"),
                new ContactTo("linkedin", "newLinkedin")));

        perform(MockMvcRequestBuilders.put(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(writeValue(USER_PROFILE_TO)))
                .andDo(print())
                .andExpect(status().isNoContent());
        PROFILE_TO_MATCHER.assertMatch(USER_PROFILE_TO, ProfileTestData.getUpdatedTo());
    }

    @Test
    @WithUserDetails(value = GUEST_MAIL)
    void testUpdateUnAuth() throws Exception {
        USER_PROFILE_TO.setMailNotifications(
            Set.of("assigned", "three_days_before_deadline", "two_days_before_deadline",
                "one_day_before_deadline", "deadline", "overdue"));
        USER_PROFILE_TO.setContacts(
            Set.of(new ContactTo("skype", "newSkype"),
                new ContactTo("mobile", "+380987654321"),
                new ContactTo("website", "new.com"),
                new ContactTo("github", "newGitHub"),
                new ContactTo("tg", "newTg"),
                new ContactTo("linkedin", "newLinkedin")));

        perform(MockMvcRequestBuilders.put(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(writeValue(USER_PROFILE_TO)))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
}