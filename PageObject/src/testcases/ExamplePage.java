package testcases;


	
	public class ExamplePage {
		  
		  private static final String SELECT_GENDER_SELECTOR = "[test-id=select-gender]";
		  
		  @FindBy(css = "[test-id=users-table] [test-id=element]")
		  private List<WebElement> userRows;

		  public void selectGenderForUser(String userName, String genderToSelect){
		    WebElement userRow = userRows.stream()
		      .filter(row -> userName
		              .equals(row.findElement(By.cssSelector("[test-id=label]")).getText()))
		      .findFirst()
		      .orElseThrow(() -> new NoSuchElementException("Element " 
		                                                    + userName 
		                                                    + " isn't displayed in the table."));
		    
		    WebElement selectGender = userRow.findElement(By.cssSelector(SELECT_GENDER_SELECTOR));
		    
		    WebElement genderOption = selectGender.findElements(By.tagName("option")).stream()
		      .filter(currentElement -> currentElement.getAttribute("value").equals(genderToSelect))
		      .findFirst()
		      .orElseThrow(() -> new NoSuchElementException("Option " 
		                                                    + genderToSelect 
		                                                    + " wasn't found in the list."));
		    genderOption.click();
		  }
		}
		  


