package sanha.book.haha.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entity 클래스, PK타입>
public interface PostsRepository extends JpaRepository<Posts,Long> {

}
