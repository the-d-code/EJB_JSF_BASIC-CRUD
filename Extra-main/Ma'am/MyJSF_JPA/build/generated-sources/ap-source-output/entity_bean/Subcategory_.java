package entity_bean;

import entity_bean.Category;
import entity_bean.Subcatmst;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-11-19T17:21:43")
@StaticMetamodel(Subcategory.class)
public class Subcategory_ { 

    public static volatile SingularAttribute<Subcategory, String> subcategoryName;
    public static volatile SingularAttribute<Subcategory, Integer> subcategoryId;
    public static volatile SingularAttribute<Subcategory, Category> categoryId;
    public static volatile CollectionAttribute<Subcategory, Subcatmst> subcatmstCollection;

}