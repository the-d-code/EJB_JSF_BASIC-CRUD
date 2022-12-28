/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author HP
 */
public enum InventoryStatus {
    INSTOCK("In Stock"),
    OUTOFSTOCK("Out of Stock"),
    LOWSTOCK("Low Stock");

    private String text;

    InventoryStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
////class InventoryStatus {
////    public enum InventoryStatus {
////    INSTOCK("In Stock"),
////    OUTOFSTOCK("Out of Stock"),
////    LOWSTOCK("Low Stock");
////
////    private String text;
////
////    InventoryStatus(String text) {
////        this.text = text;
////    }
////
////    public String getText() {
////        return text;
////    }
////}
//}
