package restaurant.mapper;

public interface Mapper<FROM,TO>
{
    TO mapToObject(FROM origin);

    FROM mapToDto(TO object);
}
