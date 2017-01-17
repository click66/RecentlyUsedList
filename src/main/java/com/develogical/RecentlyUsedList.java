package com.develogical;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentlyUsedList {

    Integer count = 0;
    List<ListItem> list;

    public RecentlyUsedList(){
        list = new ArrayList<>();
    }


    public Boolean isEmpty()
    {
        return (count == 0);
    }

    public void add(String item)
    {
        add(new ListItem(item));
    }

    public void add(Integer item)
    {
        add(new ListItem(item));
    }

    public void add(ListItem item)
    {
        count++;
        for(Iterator<ListItem> i = list.iterator(); i.hasNext(); ) {
            ListItem itItem = i.next();
            if (itItem.isEqualTo(item)) {
                i.remove();
            }
        }
        list.add(0, item);
    }

    public ListItem getFirstItem()
    {
        return getAt(0);
    }

    public Integer getCount()
    {
        return list.size();
    }

    public ListItem getAt(Integer i)
    {
        return list.get(i);
    }

    public class ListItem
    {
        private Object item;

        public ListItem(Object item)
        {
            this.item = item;
        }
        
        public Boolean isEqualTo(ListItem compItem)
        {
            return item.equals(compItem.getValue());
        }

        public Object getValue()
        {
            return item;
        }
    }
}
