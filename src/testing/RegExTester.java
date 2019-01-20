package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import expressionClasses.RegularExpr;

public class RegExTester {

	@Test
	public void test1() {
		assertEquals(true, RegularExpr.matchToPattern("abc.*", "abc"));
		assertEquals(true, RegularExpr.matchToPattern("abc.*", "abcdefg"));
		assertEquals(true, RegularExpr.matchToPattern("abc.*", "abcde"));
	}
	
	@Test
	public void test2() {
		assertEquals(true, RegularExpr.matchToPattern(".*123.*", "abc123xyz"));
		assertEquals(true, RegularExpr.matchToPattern(".*123.*", "define \"123\""));
		assertEquals(true, RegularExpr.matchToPattern(".*123.*", "var g = 123;"));
	}
	
	@Test
	public void test3() {
		assertEquals(true, RegularExpr.matchToPattern(".*\\.", "cat."));
		assertEquals(true, RegularExpr.matchToPattern(".*\\.", "896."));
		assertEquals(true, RegularExpr.matchToPattern(".*\\.", "smth."));
	}
	
	@Test
	public void test4() {
		assertEquals(true, RegularExpr.matchToPattern("[cmf].*", "can"));
		assertEquals(true, RegularExpr.matchToPattern("[cmf].*", "man"));
		assertEquals(true, RegularExpr.matchToPattern("[cmf].*", "fan"));
		assertEquals(false, RegularExpr.matchToPattern("[cmf].*", "dan"));
		assertEquals(false, RegularExpr.matchToPattern("[cmf].*", "ran"));
	}
	
	@Test
	public void test5() {
		assertEquals(true, RegularExpr.matchToPattern("[^b].*", "dog"));
		assertEquals(true, RegularExpr.matchToPattern("[^b].*", "hog"));
		assertEquals(false, RegularExpr.matchToPattern("[^b].*", "bog"));
	}
	
	@Test
	public void test6() {
		assertEquals(true, RegularExpr.matchToPattern("[^a-z].*", "Ana"));
		assertEquals(true, RegularExpr.matchToPattern("[^a-z].*", "Bob"));
		assertEquals(false, RegularExpr.matchToPattern("[^a-z].*", "aax"));
		assertEquals(false, RegularExpr.matchToPattern("[^a-z].*", "bby"));
	}
	
	@Test
	public void test7() {
		assertEquals(true, RegularExpr.matchToPattern(".*z{2}.*", "	wazzzzzup"));
		assertEquals(true, RegularExpr.matchToPattern(".*z{2}.*", "wazzzup"));
		assertEquals(false, RegularExpr.matchToPattern(".*z{2}.*", "wazup"));
	}
	
	@Test
	public void test8() {
		assertEquals(true, RegularExpr.matchToPattern("[a]+b{0,4}[c]+", "aaaabcc"));
		assertEquals(true, RegularExpr.matchToPattern("[a]+b{0,4}[c]+", "aabbbbc"));
		assertEquals(true, RegularExpr.matchToPattern("[a]+b{0,4}[c]+", "aacc"));
		assertEquals(false, RegularExpr.matchToPattern("[a]+b{0,4}[c]+", "a"));
	}
	
	@Test
	public void test9() {
		assertEquals(true, RegularExpr.matchToPattern(".*[0-9]+.*\\?", "1 file found?"));
		assertEquals(true, RegularExpr.matchToPattern(".*[0-9]+.*\\?", "2 files found?"));
		assertEquals(true, RegularExpr.matchToPattern(".*[0-9]+.*\\?", "24 files found?"));
		assertEquals(false, RegularExpr.matchToPattern(".*[0-9]+.*\\?", "No files found."));
	}
	
	@Test
	public void test10() {
		assertEquals(true, RegularExpr.matchToPattern("[0-9]+\\.\\s+abc", "1.   abc"));
		assertEquals(true, RegularExpr.matchToPattern("[0-9]+\\.\\s+abc", "2.	abc"));
		assertEquals(true, RegularExpr.matchToPattern("[0-9]+\\.\\s+abc", "3.           abc"));
		assertEquals(false, RegularExpr.matchToPattern("[0-9]+\\.\\s+abc", "4.abc"));
	}
	
	@Test
	public void test11() {
		assertEquals(true, RegularExpr.matchToPattern("^Mission:\\s+successful", "Mission: successful"));
		assertEquals(false, RegularExpr.matchToPattern("^Mission:\\s+successful", "Last Mission: unsuccessful"));
		assertEquals(false, RegularExpr.matchToPattern("^Mission:\\s+successful", "Next Mission: successful upon capture of target"));
	}
	
	@Test
	public void test12() {
		assertEquals(true, RegularExpr.matchToPattern("^(.*)\\.pdf$", "file_record_transcript.pdf"));
		assertEquals(true, RegularExpr.matchToPattern("^(.*)\\.pdf$", "file_07241999.pdf"));
		assertEquals(false, RegularExpr.matchToPattern("^(.*)\\.pdf$", "testfile_fake.pdf.tmp"));
	}
	
	@Test
	public void test13() {
		assertEquals(true, RegularExpr.matchToPattern("(\\w+\\s+([\\d]+))", "Jan 1987"));
		assertEquals(true, RegularExpr.matchToPattern("^(\\w+\\s+([\\d]+))", "May 1969"));
		assertEquals(true, RegularExpr.matchToPattern("(\\w+\\s+([\\d]+))", "Aug 2011"));
	}
	
	@Test
	public void test14() {
		assertEquals(true, RegularExpr.matchToPattern("([0-9]+).([0-9]+)", "1280x720"));
		assertEquals(true, RegularExpr.matchToPattern("([0-9]+).([0-9]+)", "1920x1600"));
		assertEquals(true, RegularExpr.matchToPattern("([0-9]+).([0-9]+)", "1024x768"));
	}
	
	@Test
	public void test15() {
		assertEquals(true, RegularExpr.matchToPattern("I\\s+love\\s+(cats|dogs)", "I love cats"));
		assertEquals(true, RegularExpr.matchToPattern("I\\s+love\\s+(cats|dogs)", "I love dogs"));
		assertEquals(false, RegularExpr.matchToPattern("I\\s+love\\s+(cats|dogs)", "I love logs"));
		assertEquals(false, RegularExpr.matchToPattern("I\\s+love\\s+(cats|dogs)", "I love cogs"));
	}
	
	@Test
	public void test16() {
		assertEquals(true, RegularExpr.matchToPattern("[\\W]*.*.$", "The quick brown fox jumps over the lazy dog."));
		assertEquals(true, RegularExpr.matchToPattern("[\\W]*.*.$", "There were 614 instances of students getting 90.0% or above."));
		assertEquals(true, RegularExpr.matchToPattern("[\\W]*.*.$", "The FCC had to censor the network for saying &$#*@!."));
	}
	
	@Test
	public void test17() {
		assertEquals(true, RegularExpr.matchToPattern("[\\-]*[\\d]+[\\.,]*[\\d]+[e\\d.]*", "3.14529"));
		assertEquals(true, RegularExpr.matchToPattern("[\\-]*[\\d]+[\\.,]*[\\d]+[e\\d.]*", "-255.34"));
		assertEquals(true, RegularExpr.matchToPattern("[\\-]*[\\d]+[\\.,]*[\\d]+[e\\d.]*", "128"));
		assertEquals(true, RegularExpr.matchToPattern("[\\-]*[\\d]+[\\.,]*[\\d]+[e\\d.]*", "1.9e10"));
		assertEquals(true, RegularExpr.matchToPattern("[\\-]*[\\d]+[\\.,]*[\\d]+[e\\d.]*", "123,340.00"));
		assertEquals(false, RegularExpr.matchToPattern("[\\-]*[\\d]+[\\.,]*[\\d]+[e\\d.]*", "720p"));
	}
}
