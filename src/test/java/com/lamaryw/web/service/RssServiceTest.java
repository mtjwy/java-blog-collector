package com.lamaryw.web.service;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lamaryw.web.entity.Item;
import com.lamaryw.web.exception.RssException;

public class RssServiceTest {
	
	private RssService rssService;

	@Before
	public void setUp() throws Exception {
		rssService = new RssService();
	}

	@Test
	public void testGetItemsFile() throws RssException {
		List<Item> items = rssService.getItems(new File("test-rss/yahoo.xml"));
		assertEquals(40, items.size());
		Item firstItem = items.get(0);
		assertEquals("We've Moved!", firstItem.getTitle());
		assertEquals("20 05 2013 07:03:24", new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstItem.getPublishedDate()));
	}

}
