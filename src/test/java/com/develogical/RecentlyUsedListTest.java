package com.develogical;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RecentlyUsedListTest
{
    @Test
    public void listIsEmptyWhenInitialised()
    {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
        assertThat(recentlyUsedList.isEmpty(), is(true));
    }

    @Test
    public void canAddItemToList()
    {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
        recentlyUsedList.add("foo");
        assertThat(recentlyUsedList.isEmpty(), is(false));
    }

    @Test
    public void canRetrieveItemFromList()
    {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
        recentlyUsedList.add("foo");
        recentlyUsedList.add("bar");
        recentlyUsedList.add("mal");
        recentlyUsedList.add("tam");
        assertThat(recentlyUsedList.getAt(2).getValue(), is("bar"));
    }

    @Test
    public void mostRecentItemFirst()
    {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
        recentlyUsedList.add("foo");
        recentlyUsedList.add("Hello World");
        assertThat(recentlyUsedList.getFirstItem().getValue(), is("Hello World"));
    }

    @Test
    public void uniqueItemsAreMoved()
    {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
        recentlyUsedList.add("bar");
        recentlyUsedList.add("Hi");
        recentlyUsedList.add("foo");
        recentlyUsedList.add("Hello World");
        recentlyUsedList.add("foo");

        assertThat(recentlyUsedList.getCount(), is(4));

        assertThat(recentlyUsedList.getAt(2).getValue(), is("Hi"));
        assertThat(recentlyUsedList.getFirstItem().getValue(), is("foo"));
    }

    @Test
    public void canGetCount()
    {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
        recentlyUsedList.add("foo");
        recentlyUsedList.add("bar");
        recentlyUsedList.add("mal");
        recentlyUsedList.add("tam");

        assertThat(recentlyUsedList.getCount(), is(4));

        recentlyUsedList.add("jayne");

        assertThat(recentlyUsedList.getCount(), is(5));
    }

    @Test
    public void doesNotOnlyTakeStrings()
    {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
        recentlyUsedList.add(1);
        assertThat(recentlyUsedList.getFirstItem().getValue(), is(1));
    }
}
