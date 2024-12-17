package br.com.linhaus.controle_estoque.entities.enums;

public enum ProductType {
    SHOES(0),
    SHIRT(1),
    VAPE(2),
    UNDERPANTS(3);
    
private int code;
	
	private ProductType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static ProductType valueOf(int code) {
		for(ProductType value : ProductType.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Product Type");
	}
}
