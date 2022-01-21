package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.Comment;
import ir.maktab58.dto.CommentDto;
import ir.maktab58.service.mapper.interfaces.CommentMapper;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class CommentMapperImpl implements CommentMapper {
    @Override
    public Comment toCommentDto(CommentDto commentDto) {
        return Comment.builder().build();
        //tODO
    }

    @Override
    public CommentDto toCommentDto(Comment comment) {
        return null;
    }
}
