package oec.lis.sopl.common.model;

import java.io.Serializable;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestRequest<T> implements Serializable {
    
    @Valid
    private T body;
}