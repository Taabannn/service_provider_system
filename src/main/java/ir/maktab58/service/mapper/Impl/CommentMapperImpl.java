package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.Comment;
import ir.maktab58.dto.CommentDto;
import ir.maktab58.service.mapper.interfaces.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class CommentMapperImpl implements CommentMapper {
    @Autowired
    private OrderMapperImpl orderMapper;

    @Override
    public Comment toCommentDto(CommentDto commentDto) {
        return Comment.builder()
                .withDetail(commentDto.getDetail())
                .withScore(commentDto.getScore())
                .withCreatedDate(commentDto.getCreatedDate())
                .withOrder(orderMapper.toOrder(commentDto.getOrder()))
                .withTrackingCode(commentDto.getTrackingCode()).build();
    }

    @Override
    public CommentDto toCommentDto(Comment comment) {
        return CommentDto.builder()
                .withDetail(comment.getDetail())
                .withScore(comment.getScore())
                .withCreatedDate(comment.getCreatedDate())
                .withOrder(orderMapper.toOrderDto(comment.getOrder()))
                .withTrackingCode(comment.getTrackingCode()).build();
    }
}
