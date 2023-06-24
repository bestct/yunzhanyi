package net.yunzhanyi.client.domain.vo;

import lombok.*;
import net.yunzhanyi.domain.pojo.Rhyme;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bestct
 * @date 2023/6/24
 * description: TODO
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RhymeBookVo {
    private String rhymeBookName;
    private List<Rhyme> rhymeList=new ArrayList<>();
}
