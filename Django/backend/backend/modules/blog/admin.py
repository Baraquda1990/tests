from django.contrib import admin
from .models import Article,Category
from mptt.admin import DraggableMPTTAdmin

@admin.register(Category)
class CategoryAdmin(DraggableMPTTAdmin):
    """
    Админ-панель модели категорий
    """
    list_display=('tree_actions','indented_title','id','title','slug')
    list_display_links=('title','slug')
    prepopulated_fields={'slug':('title',)}

    fieldsets=(
        ('Основная информация',{'fields':('title','slug','parent')}),
        ('Описание',{'fields':('description',)})
    )

admin.site.register(Article)

"""@admin.register(Article)
class ArticleAdmin(admin.ModelAdmin):
    prepopulated_fields={'slug':('title',)}"""
