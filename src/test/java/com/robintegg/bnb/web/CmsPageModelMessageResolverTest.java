package com.robintegg.bnb.web;

import org.junit.Test;
import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;

public class CmsPageModelMessageResolverTest {

	@Test
	public void test() {

		PegDownProcessor pegDownProcessor = new PegDownProcessor(Extensions.NONE);

		System.out.println(pegDownProcessor.markdownToHtml("just some text"));
		
		System.out.println("----");
		
		System.out.println(pegDownProcessor.markdownToHtml("just some text\nsomemore text"));
		
		System.out.println(pegDownProcessor.markdownToHtml("this is some text\r\n## header 2"));
	}

}
