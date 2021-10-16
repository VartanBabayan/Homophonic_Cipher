/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.vartan.babayan.modelCipher;

/**
 * Exception to handle errors when 
 * the message for E[ncryption] or [D]ecryption is not valid
 * @author vartan
 */
public class MessageCorrectnessException extends Exception {
    public MessageCorrectnessException(String exceptionMessage) {
        super(exceptionMessage);
    }
}