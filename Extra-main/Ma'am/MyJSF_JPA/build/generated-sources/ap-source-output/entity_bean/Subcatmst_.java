package entity_bean;

import entity_bean.Category;
import entity_bean.Subcategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-11-19T17:21:43")
@StaticMetamodel(Subcatmst.class)
public class Subcatmst_ { 

    public static volatile SingularAttribute<Subcatmst, Subcategory> subcategoryId;
    public static volatile SingularAttribute<Subcatmst, Integer> subcatmstId;
    public static volatile SingularAttribute<Subcatmst, Category> categoryId;

}