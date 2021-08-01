package seleniumPack;

public class XpathLocator {

	public static void main(String[] args) {
		
		// child - / => //fieldset/div
		// child and grand child - // => //fieldset//label
		
		// parent - parent::tagName => //label/parent::div
		// parent and grand-parent - ancestor::tagName => //label/ancestor::fieldset
		
		// preceding-sibling => //label[text()='User Name:']/following-sibling::input
		// following-sibling => //input[@name='user']/preceding-sibling::label
		
		// text() => //a[text()='Basic Contact Form']
		// contains() => //a[contains(text(),' Contact ')]
		// starts-with() => //a[starts-with(text(),'Basic ')]
		
		// and => //a[starts-with(text(),'B') and contains(text(),' Form')]
		// or => //a[text()='Basic Contact Form' or text()='Business Contact Form']
		
		// position() => (//select)[position()!=3]
		// last() => (//select)[last()]

	}

}
