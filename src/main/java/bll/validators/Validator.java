package bll.validators;

/**
 * Validator interface
 *
 * @author Risteiu Ioana
 * @since May 19, 2024
 */
public interface Validator<T> {

    public boolean validate(T t);
}
