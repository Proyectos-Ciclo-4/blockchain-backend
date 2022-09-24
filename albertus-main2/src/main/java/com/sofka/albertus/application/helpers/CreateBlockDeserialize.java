package com.sofka.albertus.application.helpers;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonSerialize(using= CustomJson.class)
public class CreateBlockDeserialize {

    String data;
}
