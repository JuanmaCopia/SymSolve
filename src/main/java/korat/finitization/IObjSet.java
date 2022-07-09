package korat.finitization;

public interface IObjSet extends IFieldDomain {

    /**
     * Returns all objest in entire <code>IObjSet</code>.Those are all
     * objects that can be assigned to the field that this
     * <code>IFieldDomain</code> is assigned to.
     *
     * @return all objects in this field domain.
     */
    Object[] getAllObjects();

    /**
     * Returns instances (direct or indirect) of the given class in entire
     * <code>IObjSet</code>
     *
     * @param cls base class
     * @return objects of this field domain which are instances (direct or
     * indirect) of the given class. If there are no such objects,
     * returns zero-size array
     * @see #getAllObjects()
     */
    Object[] getObjectsOfClass(Class<?> cls);

    /**
     * Is null allowed or not.
     *
     * @return is null allowed
     * @see #isNullAllowed()
     */
    boolean isNullAllowed();

    /**
     * Sets whether <code>null</code> is allowed or not. By default
     * <code>null</code> is not allowed.
     *
     * @param allowed whether <code>null</code> value is allowed.
     * @see #isNullAllowed()
     */
    void setNullAllowed(boolean allowed);
}
