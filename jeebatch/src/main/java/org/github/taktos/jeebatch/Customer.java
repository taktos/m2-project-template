/**
 * 
 */
package org.github.taktos.jeebatch;

/**
 * dummy customer data from http://kazina.com/dummy/
 * 
 * @author taktos
 * 
 */
public class Customer {
    private String name;
    private String furigana;
    private String email;

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getFurigana() {
        return this.furigana;
    }

    public void setFurigana(final String furigana) {
        this.furigana = furigana;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
