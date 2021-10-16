/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pl.polsl.lab.vartan.babayan.modelCipher;

/**
 *
 * @author vartan
 */
public interface Cipher {
    String encryptMessage(String message);
    String decryptMessage(String message);
}