package online.codevault.jooq.datahelpers;

import org.jooq.*;

public class SingleRecordAccessor {

    public <T extends org.jooq.impl.UpdatableRecordImpl> T get(DSLContext context, Table table, Condition condition) {

        return (T) context
                .select()
                .from(table)
                .where(condition)
                .fetchOneInto(table.getRecordType().getClass())
                .cast(table.getRecordType().getClass());

    }

}
