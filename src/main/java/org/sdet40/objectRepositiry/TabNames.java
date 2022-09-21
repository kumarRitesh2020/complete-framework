package org.sdet40.objectRepositiry;

public enum TabNames {
	HOME("Home"),CUSTOMER("Customer"),EMPLOYEE("Employee"),PRODUCT("Product"),INVENTORY("Inventory"),TRANSACTION("Transaction"),SUPPLIER("Supplier"),ACCOUNTS("Accounts"),POS("POS");
 private String tabName;
 private TabNames(String tabName) {
	 this.tabName=tabName;
	 
 }
 
 public String getTabName() {
	return tabName;
	 
 }
}
