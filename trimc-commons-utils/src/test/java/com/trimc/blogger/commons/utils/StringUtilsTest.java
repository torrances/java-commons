package com.trimc.blogger.commons.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.junit.Test;

import com.trimc.blogger.commons.utils.string.StringUtils;

public final class StringUtilsTest {

	@Test
	public void split1() throws Throwable {
		String t1 = "Etymology:  < Anglo-Norman abandun, abaundun abandonment, surrender (first half of the 13th cent. or earlier) and Middle French abandon power, jurisdiction, discretion (12th cent. in Old French (see phrases below); French abandon  ; also in sense ‘freedom from constraint’ (1607 in en abandon   without constraint)) < a bandon   (see abandon adv.). Compare post-classical Latin abandonum  , abandonium   (13th cent.), abandum   (late 12th cent.), all in sense ‘security’. Compare ( < French) Old Occitan abandon  , Catalan abandó   (13th cent.), Spanish abandono   (14th cent.), Italian abbandono   (c1294). Compare earlier bandon n.   (With to hold under one's abandon at sense 2   compare earlier to be in any one's bandon, to be at any one's bandon; with to put in a person's abandon at sense 2   compare in one's bandon at bandon n. 1.) Compare also later abandon n.2 With at abandoun   compare Middle French a abandon   at (a person's) disposal, at (a person's) mercy (late 12th cent. in Old French); with in abandoun   compare Middle French en abandon   at risk, at (a person's) disposal (both c1165 in Old French in metre en abandun  ), impetuously (c1369).  With to put in a person's abandon at sense 2   compare post-classical Latin ponere in abandonum  , ponere in abandonium   (13th cent.), Middle French mettre en abandon   to put at (a person's) disposal (c1165 in Old French). With to give in abandon at sense 1   compare post-classical Latin dare in abandonum, dare in abandonium (13th cent.).(Show Less)";
		Collection<String> lines = StringUtils.split(t1, 120, false);

		assertNotNull(lines);
		assertEquals(11, lines.size());
	}

	@Test
	public void split2() throws Throwable {
		String input = "microbial influenced corrosion and underdeposit corrosion";
		Collection<String> l1 = StringUtils.split(input, 25, false);
		assertNotNull(l1);
		assertEquals(2, l1.size());
	}

	@Test
	public void trim1() throws Throwable {
		String t1 = " hello   world  ";
		assertEquals("hello world", StringUtils.trim(t1));
	}

	@Test
	public void trim2() throws Throwable {
		String t1 = " hello \n"
				+ "  world  ";
		assertEquals("hello world", StringUtils.trim(t1));
	}
}
