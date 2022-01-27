package ir.maktab58.service.mapper.interfaces;

import ir.maktab58.data.entities.Comment;
import ir.maktab58.dto.CommentDto;
import org.mapstruct.Mapper;

/**
 * @author Taban Soleymani
 */
@Mapper
public interface CommentMapper {
    Comment toCommentDto(CommentDto commentDto);

    CommentDto toCommentDto(Comment comment);
}
