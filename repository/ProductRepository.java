package com.teamfive.search_elastic.repository;

import com.teamfive.search_elastic.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product,String> {

    @Query("{\"bool\" : {\"must\" : {\"match\" : {\"productName\" : \"?0\"}}}}")
    Page<Product> findProductByQuery(@Param("query") String query, Pageable pageable);

    @Query("{ " +
            " \"query\":{ " +
            "  \"bool\":{ " +
            "   \"should\": " +
            "   { " +
            "    \"boosting\": " +
            "    { " +
            "     \"positive\":{ " +
            "      \"query_string\" : { " +
            "       \"fields\" : [\"productName^5\", \"description\"], " +
            "       \"query\" : \"?0\", " +
            "       \"tie_breaker\" : 0 " +
            "      } " +
            "     }, " +
            "     \"negative\":{ " +
            "      \"term\":{ " +
            "       \"isOutOfStock\": true " +
            "      } " +
            "     }, " +
            "     \"negative_boost\": 0.2 " +
            "    } " +
            "   }, " +
            "   \"filter\":{ " +
            "    \"match\":{ " +
            "     \"category\": \"?1\" " +
            "    } " +
            "   } " +
            "  } " +
            " } " +
            "}")
    Page<Product> findProductByQuery(String query,String category,Pageable pageable);

}
