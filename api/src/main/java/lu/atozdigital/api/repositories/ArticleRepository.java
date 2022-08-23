package lu.atozdigital.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lu.atozdigital.api.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
