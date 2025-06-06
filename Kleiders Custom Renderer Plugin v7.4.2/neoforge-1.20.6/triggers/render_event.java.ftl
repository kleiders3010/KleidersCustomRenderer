<#include "procedures.java.ftl">
@EventBusSubscriber(value = {Dist.CLIENT})
public class ${name}Procedure {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onEventTriggered(RenderLivingEvent.Pre event) {
        <#assign dependenciesCode><#compress>
            <@procedureDependenciesCode dependencies, {
            "x": "event.getEntity().getX()",
            "y": "event.getEntity().getY()",
            "z": "event.getEntity().getZ()",
            "entity": "event.getEntity()",
            "world": "event.getEntity().level()",
            "event": "event"
            }/>
        </#compress></#assign>
        execute(event<#if dependenciesCode?has_content>,</#if>${dependenciesCode});
    }
